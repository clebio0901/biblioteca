
package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import model.Revista;
import model.Artigo;

public class ObraDAO {
	private static final String FILE_PATH = "data/obras.json";
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static List<Obra> carregarObras() {
		List<Obra> lista = new ArrayList<>();
		try (Reader reader = new FileReader(FILE_PATH)) {
			JsonArray array = JsonParser.parseReader(reader).getAsJsonArray();
			for (JsonElement elem : array) {
				JsonObject obj = elem.getAsJsonObject();
				String tipo = obj.get("type").getAsString();

				switch (tipo) {
				case "Livro":
					lista.add(new Gson().fromJson(obj, Livro.class));
					break;
				case "Revista":
					lista.add(new Gson().fromJson(obj, Revista.class));
					break;
				case "Artigo":
					lista.add(new Gson().fromJson(obj, Artigo.class));
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static void salvarObras(List<Obra> obras) {
		try (Writer writer = new FileWriter(FILE_PATH)) {
			gson.toJson(obras, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
