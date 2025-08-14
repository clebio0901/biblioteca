package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Usuario;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class UsuarioDAO {
    private static final String FILE_PATH = "data/usuarios.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Usuario> carregarUsuarios() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Usuario>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void salvarUsuarios(List<Usuario> usuarios) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
