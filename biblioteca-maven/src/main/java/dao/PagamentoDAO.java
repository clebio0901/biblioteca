package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class PagamentoDAO {
    private static final String FILE_PATH = "data/pagamentos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<MultaDAO> carregarPagamentos() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<MultaDAO>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void salvarPagamentos(List<MultaDAO> pagamentos) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(pagamentos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
