public class Playlist
{
    private String listName;
    private Song[] songs;
    private int[] stars;
    public long datecounter;
    public Playlist(String listName)
    {
        this.listName = listName;
        Artist testdummy = new Artist("testdummy");
        Artist fakedummy = new Artist("fakedummy");
        this.songs = new Song[4];
        this.stars = new int[4];
        this.songs[0] = new Song("Song 1", testdummy);
        this.songs[1] = new Song("Song 2", testdummy);
        this.songs[2] = new Song("Song 3", fakedummy);
        this.songs[3] = new Song("Song 4", fakedummy);
        this.stars[0] = 1;
        this.stars[1] = 2;
        this.stars[2] = 3;
        this.stars[3] = 4;
        
        for(Song asong: songs)
        {
            asong.date += datecounter;
            datecounter++;
        }
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
        int artistcount = 0;
        for(int i = 0; i < ln; i ++)
        {
            if(songs[i].getArtist().getName().equals(artist.getName()))
            starssum += stars[i];
            artistcount ++;
        }
        return starssum/artistcount;
    }
    
    public Song[] getSongs(Artist artist)
    {
        Song[] artistsongs = new Song[0];
        int[] artiststars = new int[0];
        for(int i = 0; i < songs.length; i ++)
        {
            if(songs[i].getArtist().equals(artist))
            {
                artistsongs = getSonghelper(songs[i], artistsongs);
                artiststars = getStarhelper(stars[i], artiststars);
            }
        }
        return artistsongs;
    }
    
    public Song[] getSongs()
    {
        return songs;
    }
    
    public int[] getStars()
    {
        return stars;
    }
    
    //getSongs Helper
    
     public Song[] getSonghelper(Song song, Song[] artistsongs)
    {
        int sln = artistsongs.length;
        Song[] tempsongs = new Song[sln+1];
        for(int i = 0; i < sln; i++)
        tempsongs[i] = artistsongs[i];
        tempsongs[sln] = song;
        return tempsongs;
    }
    
    public int[] getStarhelper(int stars, int[] artiststars)
    {
        int sln = artiststars.length;
        int[] tempstars = new int[sln+1];
        for(int i = 0; i < sln; i++)
        tempstars[i] = artiststars[i];
        tempstars[sln] = stars;
        return tempstars;
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
        song.date += datecounter;
        datecounter++;
        Song[] tempsongs = new Song[sln+1];
        tempsongs[sln] = song;
        int[] tempstars = new int[sln+1];
        tempstars[sln] = star;
        for(int i = 0; i < sln; i ++)
        {
            tempsongs[i] = songs[i];
            tempstars[i] = stars[i];
        }
        stars = tempstars;
        songs = tempsongs;
    }
    
    public void removeSong(Song song, String artist )
    {        
        int sln = songs.length;
        int count = 0;
        for(int i = 0; i < sln; i ++)
        {
            if(songs[i].equals(song) && songs[i].getArtist().getName().equals(artist))
            count++;
        }
        Song[] tempsongs = new Song[sln-count];
        int[] tempstars = new int[sln-count];
        count = 0;
        for(int i = 0; i < sln; i ++)
        {
            if(songs[i].equals(song) && songs[i].getArtist().getName().equals(artist))
            count++;
            else
            {
                tempsongs[i-count] = songs[i];
                tempstars[i-count] = stars[i];
            }
        }
        songs = tempsongs;
        stars = tempstars;
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
        songs = tempsongs;
        stars = tempstars;
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
        songs = tempsongs;
        stars = tempstars;
    }
    
    public Playlist sortByDate()
    {
        int sln = stars.length;
        long[] dates = new long[sln];        
        long tempdate = 0;
        for(int i = 0; i < sln; i++)
        dates[i] = songs[i].date;
        
        int index = 0;
        
        for(int i = 0; i < sln; i++)
        {
            index = i;
            for(int x = i+1; x < sln; x++)
            {
                if(dates[x] < dates[index])
                index = x;
            }
            tempdate = dates[i];
            dates[i] = dates[index];
            dates[index] = tempdate;
        }
        
        Song[] tempsongs = new Song[sln];
        int[] tempstars = new int[sln];
        Playlist temp = new Playlist(this.listName);
        for(int i = 0; i < sln; i++)
        {
            for(int x = i; x < sln; x++)
            if(songs[x].date == dates[i])
            {
                temp.songs[i] = songs[x];
                temp.stars[i] = stars[x];
            }
        }
        return temp;
    }
    
    public Playlist sortByRating()
    {
        int sln = stars.length;
        int most = 0;
        boolean index = true;
        int indexmost = 0;
        int[] indexes = new int[sln];
        for(int i = 0; i < sln; i ++)
        indexes[i] = -1;
        for(int i = 0; i < sln; i++)
        {
            most = 0;
            for(int x = 0; x < sln; x++)
            {
                index = true;
                for(int z = 0; z < indexes.length; z++)
                if(indexes[z] == x)
                index = false;
                if(stars[x] >= most && index == true)
                {
                    indexmost = x;
                    most = stars[x];
                }
            }
            indexes[i] = indexmost;
        }
        
        Song[] tempsongs = new Song[sln];
        int[] tempstars = new int[sln];
        
        Playlist temp = new Playlist(this.listName);
        
        for(int i = 0; i < sln; i++)
        {
            for(int x = 0; x < sln; x++)
            if(x == indexes[i])
            {
                temp.songs[i] = songs[x];
                temp.stars[i] = stars[x];
            }
        }
        return temp;
    }
    
    public Playlist shuffle()
    {
        int sln = stars.length;
        double[] shuffler = new double[sln];
        for(int i = 0; i < sln; i ++)
        shuffler[i] = Math.random();
        
        double most = 0;
        boolean index = true;
        int indexmost = 0;
        int[] indexes = new int[sln];
        for(int i = 0; i < sln; i ++)
        indexes[i] = -1;
        
        for(int i = 0; i < sln; i++)
        {
            most = 0;
            for(int x = 0; x < sln; x++)
            {
                index = true;
                for(int z = 0; z < indexes.length; z++)
                if(indexes[z] == x)
                index = false;
                if(shuffler[x] >= most && index == true)
                {
                    indexmost = x;
                    most = shuffler[x];
                }
            }
            indexes[i] = indexmost;
        }
        
        Playlist temp = new Playlist(this.listName);
        for(int i = 0; i < sln; i++)
        {
            for(int x = 0; x < sln; x++)
            if(x == indexes[i])
            {
                temp.songs[i] = songs[x];
                temp.stars[i] = stars[x];
            }
        }
        return temp;
    }
}
