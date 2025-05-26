import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 1. 장르별 노래 리스트와 총 재생횟수 저장
        Map<String, List<Info>> genreMap = new HashMap<>();
        Map<String, Integer> genrePlayCount = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            
            // 장르별 리스트 생성/가져오기
            if(!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
            }
            genreMap.get(genre).add(new Info(genre, plays[i], i));
            
            // 장르별 총 재생횟수 계산
            if(!genrePlayCount.containsKey(genre)) {
                genrePlayCount.put(genre, 0);
            }
            genrePlayCount.put(genre, genrePlayCount.get(genre) + plays[i]);
        }
        
        // 2. 장르를 총 재생횟수 순으로 정렬
        List<String> genreList = new ArrayList<>();
        for(String genre : genrePlayCount.keySet()) {
            genreList.add(genre);
        }
        
        // 버블정렬로 장르 정렬 (총 재생횟수 내림차순)
        for(int i = 0; i < genreList.size(); i++) {
            for(int j = 0; j < genreList.size() - 1 - i; j++) {
                String genre1 = genreList.get(j);
                String genre2 = genreList.get(j + 1);
                if(genrePlayCount.get(genre1) < genrePlayCount.get(genre2)) {
                    // swap
                    genreList.set(j, genre2);
                    genreList.set(j + 1, genre1);
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        // 3. 각 장르에서 최대 2곡씩 선택
        for(String genre : genreList) {
            List<Info> songs = genreMap.get(genre);
            
            // 노래 정렬 (재생횟수 내림차순, 고유번호 오름차순)
            for(int i = 0; i < songs.size(); i++) {
                for(int j = 0; j < songs.size() - 1 - i; j++) {
                    Info song1 = songs.get(j);
                    Info song2 = songs.get(j + 1);
                    
                    boolean needSwap = false;
                    if(song1.plays < song2.plays) {
                        needSwap = true;
                    } else if(song1.plays == song2.plays && song1.index > song2.index) {
                        needSwap = true;
                    }
                    
                    if(needSwap) {
                        songs.set(j, song2);
                        songs.set(j + 1, song1);
                    }
                }
            }
            
            // 최대 2곡까지 선택
            int count = Math.min(2, songs.size());
            for(int i = 0; i < count; i++) {
                result.add(songs.get(i).index);
            }
        }
        
        // List를 배열로 변환
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    class Info {
        String genre;
        int plays;
        int index;
        
        Info(String genre, int plays, int index) {
            this.genre = genre;
            this.plays = plays;
            this.index = index;
        }
    }
}