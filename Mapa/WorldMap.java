package Mapa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class WorldMap{


    protected final HashMap<String,Room> hashMap = new HashMap<>();
    public HashMap<String,Room> load() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("direction.txt"));
        String s;
        String id = "";
        Random rd = new Random();
        while((s = bufferedReader.readLine()) != null){
            id ="";
            String name = "";
            int i = 0;
            int i1 = 0;
            // getting the id
            while(s.charAt(i1)!=' '){
                id = id + s.charAt(i1);
                i1++;
            }
            i1++; // skips the useless space between the id and room name
            // getting the name
            while (s.substring(i1).charAt(i)!=' '){
                name = name + s.charAt(i1+i);
                i++;
            }
            i++; // skips the useless space between the id and room name
            //optimize this
            String sever = "";
            String jih = "";
            String vychod = "";
            String zapad = "";
            boolean[] b ={true,false,false,false};
            for(int offset = i+i1; offset < s.length();offset++){
                if (s.charAt(offset)!=' '&& b[0]){
                sever = sever + s.charAt(offset);
                    continue;
                }else if (b[0]){
                    b[0] = false;
                    b[1] = true;
                    continue;
                }
                if (s.charAt(offset)!=' '&& b[1]){
                    jih = jih + s.charAt(offset);
                }else if (b[1]){
                    b[1] = false;
                    b[2] = true;
                    continue;
                }
                if (s.charAt(offset)!=' '&& b[2]){
                    vychod = vychod + s.charAt(offset);
                }else if (b[2]){
                    b[2] = false;
                    b[3] = true;
                    continue;
                }
                if (s.charAt(offset)!=' '&& b[3]){
                    zapad = zapad + s.charAt(offset);
                }else if (b[3]){
                    b[3] = false;
                }
            }
            Room room = new Room(id,sever,jih,vychod,zapad,name, rd.nextInt(5),true,false);

            hashMap.put(id,room);
        }
        hashMap.get(id).setWinCondition(true);
        hashMap.get(id).setEvent(9);

        hashMap.put("wall",new Room("wall","-1","-1","-1","-1","?",0,false,false));
        return hashMap;
    }

    public HashMap<String,Room> getHashMap(){
        return hashMap;
    }
}
