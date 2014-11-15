public class Playlist
{
    private String listName;
    private Song[] songs;
    private int[] stars;
    public Playlist(String listName)
    {
        this.listName = listName;
    }
    
    
    //Accessor's
    
    
    public double averageRating()
    {
        int starssum = 0;
        int ln = stars.length;
        for(int i = 0; i < ln; i ++)
        starssum += stars[i];
        return starssum/ln;
    }
    
    public double averageRating(Artist artist)
    {
        int starssum = 0;
        int ln = stars.length;
        for(int i = 0; i < ln; i ++)
        {
            if(songs[i].getArtist().equals(artist))
            starssum += stars[i];
        }
        return starssum/ln;
    }
    
    public Song[] getSongs(Artist artist)
    {
        Song[] artistsongs = new Song[0];
        for(int i = 0; i < songs.length; i ++)
        {
            if(songs[i].getArtist().equals(artist))
            {
                
            }
        }
        return artistsongs;
    }
    
    
    //Mutator's
    
    
    public void swap(Song song1, Song song2)
    {
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < songs.length; i ++)
        {
            if(songs[i].equals(song1))
            index1 = i;
            if(songs[i].equals(song2))
            index2 = i;
        }
        Song tempsong = songs[index1];
        int tempstars = stars[index1];
        songs[index1] = songs[index2];
        stars[index1] = stars[index2];
        songs[index2] = tempsong;
        stars[index2] = tempstars;
    }
    
    public void addSong(Song song, int star)
    {
        int sln = songs.length;
        Song[] tempsongs = new Song[sln+1];
        tempsongs[sln] = song;
        songs = tempsongs;
        int[] tempstars = new int[sln+1];
        tempstars[sln] = star;
        stars = tempstars;
    }
    
    public void removeSong(Song song, String artist )
    {        
        int sln = songs.length;
        int count = 0;
        for(int i = 0; i < sln; i ++)
        {
            if(songs[i].equals(song) && songs[i].getArtist().equals(artist))
            count++;
        }
        Song[] tempsongs = new Song[sln-count];
        int[] tempstars = new int[sln-count];
        count = 0;
        for(int i = 0; i < sln; i ++)
        {
            if(songs[i].equals(song) && songs[i].getArtist().equals(artist))
            count++;
            else
            {
                tempsongs[i-count] = songs[i];
                tempstars[i-count] = stars[i];
            }
        }
    }
    
    public void removeArtist(Artist artist )
    {
        int sln = songs.length;
        int count = 0;
        for(int i = 0; i < sln; i ++)
        {
            if(songs[i].getArtist().equals(artist))
            count++;
        }
        Song[] tempsongs = new Song[sln-count];
        int[] tempstars = new int[sln-count];
        count = 0;
        for(int i = 0; i < sln; i ++)
        {
            if(songs[i].getArtist().equals(artist))
            count++;
            else
            {
                tempsongs[i-count] = songs[i];
                tempstars[i-count] = stars[i];
            }
        }
    }
    
    public void removeLowStars(int cutOff)
    {
        int sln = stars.length;
        int count = 0;
        for(int i = 0; i < sln; i ++)
        {
            if(stars[i]<cutOff)
            count++;
        }
        Song[] tempsongs = new Song[sln-count];
        int[] tempstars = new int[sln-count];
        count = 0;
        for(int i = 0; i < sln; i ++)
        {
            if(stars[i]<cutOff)
            count++;
            else
            {
                tempsongs[i-count] = songs[i];
                tempstars[i-count] = stars[i];
            }
        }
    }
    
    public Playlist sortByDate()
    {
        int sln = stars.length;
        long[] dates = new long[sln];        
        long least = songs[0].date;
        for(int i = 0; i < sln; i++)
        {
            least = songs[i].date;
            for(int x = i; x < sln; x++)
            {
                if(songs[x].date < least)
                least = songs[x].date;
            }
            dates[i] = least;
        }
        Song[] tempsongs = new Song[sln];
        int[] tempstars = new int[sln];
        for(int i = 0; i < sln; i++)
        {
            for(int x = i; x < sln; x++)
            if(songs[x].date == dates[i])
            {
                tempsongs[i] = songs[x];
                tempstars[i] = stars[x];
            }
        }
        
        Playlist temp = new Playlist(this.listName);
        temp.songs = tempsongs;
        temp.stars = tempstars;
        
        return temp;
    }
    
    public Playlist sortByRating()
    {
        int sln = stars.length;
        int[] rating = new int[sln];        
        int most = stars[0];
        for(int i = 0; i < sln; i++)
        {
            most = stars[i];
            for(int x = i; x < sln; x++)
            {
                if(stars[x] > most)
                most = stars[x];
            }
            rating[i] = most;
        }
        Song[] tempsongs = new Song[sln];
        int[] tempstars = new int[sln];
        for(int i = 0; i < sln; i++)
        {
            for(int x = i; x < sln; x++)
            if(stars[x] == rating[i])
            {
                tempsongs[i] = songs[x];
                tempstars[i] = stars[x];
            }
        }
        
        Playlist temp = new Playlist(this.listName);
        temp.songs = tempsongs;
        temp.stars = tempstars;
        
        return temp;
    }
    
    public Playlist shuffle()
    {
        int sln = stars.length;
        double[] shuffler = new double[sln];
        for(int i = 0; i < sln; i ++)
        shuffler[i] = Math.random();
        
        double lastmost = 1.1;
        double most = -1;
        int indexmost = 0;
        int lastindex = -1;
        Song[] tempsongs = new Song[sln];
        int[] tempstars = new int[sln];
        for(int i = 0; i < sln; i++)
        {
            most = -1;
            for(int x = 0; x < sln; x++)
            {
                if(shuffler[x] > most && shuffler[x] <= lastmost && x != lastindex)
                indexmost = x;
                most = shuffler[x];
            }
            tempsongs[i] = songs[indexmost];
            tempstars[i] = stars[indexmost];
            lastmost = most;
            lastindex = indexmost;
        }
        
        Playlist temp = new Playlist(this.listName);
        temp.songs = tempsongs;
        temp.stars = tempstars;
        
        return temp;
    }
}
