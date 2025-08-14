package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Emprestimo;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class EmprestimoDAO {
    private static final String FILE_PATH = "data/emprestimos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Emprestimo> carregarEmprestimos() {
        try  {
        	Reader reader = new FileReader(FILE_PATH);
            Type listType = new TypeToken<List<Emprestimo>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<Emprestimo>();
        }
    }

    public static void salvarEmprestimos(List<Emprestimo> emprestimos) {
        try  {
        	Writer writer = new FileWriter(FILE_PATH);
            gson.toJson(emprestimos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

