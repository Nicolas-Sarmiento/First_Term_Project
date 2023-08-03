package co.edu.uptc.controller;

import co.edu.uptc.model.Forum;

import java.util.ArrayList;

public class ForumController {
    private ArrayList<Forum> forums;
    public ForumController(){
        forums=new ArrayList<>();
    }
    public boolean createdForum(String titleForum,String description){
        Forum f=new Forum(titleForum,description);
        forums.add(f);
        return true;
    }
    public String seeForum(String title){
        String aux="";
        for (Forum c:forums) {
            if(c.getTitulo().equals(title)){
                aux=c.toString()+"\n";
                ArrayList<String> w=c.getAnswerForum();
                for (String f:w) {
                    aux+=f;
                }
                return aux;
            }
        }
        return "not fount forum";
    }
    public boolean deleteForum(String title){
        for (Forum c:forums) {
            if(c.getTitulo().equals(title)){
                forums.remove(c);
                return true;
            }
        }
        return false;
    }
    public String seeTitles(){
        String aux="";
        for (Forum c:forums) {
            aux+=c.getTitulo()+"\n";
        }
        return aux;
    }
    public boolean addComment(String title,String comment){
        for (Forum c:forums) {
            if(c.getTitulo().equals(title)){
                c.addAnswer(comment);
                return true;
            }
        }
        return false;
    }
    public boolean deleteComment(String title,String comment){
        for (int i=0;i<forums.size();i++) {
            ArrayList<String> aux=forums.get(i).getAnswerForum();
            if (forums.get(i).getTitulo().equals(title)&&aux.get(i).equals(comment)){
                aux.remove(comment);
                forums.get(i).setAnswerForum(aux);
                return true;
            }
        }
        return false;
    }
}
