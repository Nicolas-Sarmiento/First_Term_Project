package co.edu.uptc.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Forum {

    private String titulo;
    private String DescripcionDelForo;
    private ArrayList<String> answerForum;
    public Forum(String titulo, String descripcionDelForo) {
        this.titulo = titulo;
        DescripcionDelForo = descripcionDelForo;
    }
   
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcionDelForo() {
        return DescripcionDelForo;
    }
    public void setDescripcionDelForo(String descripcionDelForo) {
        DescripcionDelForo = descripcionDelForo;
    }

    public ArrayList<String> getAnswerForum() {
        return answerForum;
    }
    //esta son las respuestas del foro
    public void setAnswerForum(ArrayList<String> answerForum) {
        this.answerForum = answerForum;
    }

    public void addAnswer(String answer){
        this.answerForum.add(answer);
    }


}
