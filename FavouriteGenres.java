
//Approach - 1: HashMap
//Time Complexity : O(m*n) // users * songs
//Space Complexity : O(n) // songs

public class Main {   
public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

        //Song to Genre Map
        HashMap<String, String> songsToGenre = new HashMap<>();
        //To maintain Each user genre count 
        HashMap<String, Integer> countMap;
        HashMap<String, List<String>> result = new HashMap<>();
        for(String genre: genreMap.keySet()){
            for(String song : genreMap.get(genre)){
                songsToGenre.put(song, genre);
            }
        }
    
        for(String user :  userMap.keySet()){
            result.put(user, new ArrayList<>());
            countMap  = new HashMap<>();
            int max = 0;
            for(String song : userMap.get(user)){
                String genre = songsToGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre, 0)+1);
                max = Math.max(max, countMap.get(genre));
            }

            for(String genre : countMap.keySet()){
                if(max == countMap.get(genre)){
                    result.get(user).add(genre);
                }
            }
        }
    return result;  
}

public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));

        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);
  }

    
}

