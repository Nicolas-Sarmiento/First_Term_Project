package co.edu.uptc.model;

import java.util.ArrayList;

public class Forum {

    private String titulo;
    private String DescripcionDelForo;
    private ArrayList<Answer> answerForum;
    public Forum(String titulo, String descripcionDelForo) {
        this.titulo = titulo;
        DescripcionDelForo = descripcionDelForo;
        this.answerForum = new ArrayList<>();
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

    public ArrayList<Answer> getAnswerForum() {
        return answerForum;
    }
    //esta son las respuestas del foro
    public void setAnswerForum(ArrayList<Answer> answerForum) {

        this.answerForum = answerForum;
    }

    public void addAnswer(String answer, Person person){

        Answer answerForum = new Answer(answer , person);
        this.answerForum.add(answerForum);
    }

    @Override
    public String toString() {
        return "Forum{" +
                "titulo='" + titulo + '\'' +
                ", DescripcionDelForo='" + DescripcionDelForo + '\'' +
                '}';
    }




}
