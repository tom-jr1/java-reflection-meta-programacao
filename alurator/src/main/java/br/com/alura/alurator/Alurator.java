package br.com.alura.alurator;

import org.apache.commons.lang3.StringUtils;

public class Alurator {
    private final String qualifyName;

    public Alurator(String qualifyName) {
        this.qualifyName = qualifyName;
    }

    public Object executa(String url) {

        String[] urlFragmentos = url.replaceFirst("/", "").split("/");

        try {
            String qualifyName = String.format("%s.%s%s", this.qualifyName, StringUtils.capitalize(urlFragmentos[0]), "Controller");
            Class<?> myClass = Class.forName(qualifyName);

            Object object = myClass.newInstance();
            System.out.println(object);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return null;
    }
}
