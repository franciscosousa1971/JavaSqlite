/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasqlite;

import java.util.Iterator;

/**
 *
 * @author seduc
 */
public class JavaSqlite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            SQLite dbCon = new SQLite("pessoas.db");

            dbCon.initDB();
            dbCon.insert(new Pessoa("Amanda", 19));
            dbCon.insert(new Pessoa("Júlio", 20));
            dbCon.insert(new Pessoa("Letícia", 10));

            JavaSqlite.listaTodos(dbCon);

            System.out.println("Removemos a pessoa com o nome Fulano e listamos novamente\n");
            dbCon.removePessoa("Fulano");

            JavaSqlite.listaTodos(dbCon);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listaTodos(SQLite dbCon) {
        Iterator it = dbCon.getAll().iterator();
        Pessoa hs;
        while (it.hasNext()) {
            hs = (Pessoa) it.next();
            System.out.println("Nome:" + hs.getNome());
            System.out.println("Idade:" + hs.getIdade() + "\n");
        }
    
    }
    
}
