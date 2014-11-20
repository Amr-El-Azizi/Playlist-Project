public class Artist
{
    private String artistName;
    private Song[] songs;
    public Artist(String name)
    {
        this.artistName = name;
        this.songs = new Song[3];
        this.songs[0] = new Song("Song 1", this);
        this.songs[1] = new Song("Song 2", this);
        this.songs[2] = new Song("Song 3", this);
    }
    
    public int indexOf(String songName)
    {
        for(int i = 0; i < songs.length; i ++)
        {
            if(songs[i].songName.equals(songName))
            return i;
        }
        return -1;
    }
    
    public void addSong(Song song)
    {
        int sl = songs.length;
        Song[] output = new Song[sl+1];
        for(int i = 0; i < sl; i ++)
        output[i] = songs[i];
        output[sl] = song;
        songs = output;
    }
    
    public void removeSong(Song song)
    {
        int sl = songs.length;
        Song[] output = new Song[sl-1];
        int songfound = 0;
        Song testsong1 = new Song("hi", this);
        Song testsong2 = new Song("hello", this);
        for(int i = 0; i < sl; i ++)
        {
            if(songs[i].equals(song))
            songfound++;
            else
            output[i-songfound] = songs[i];
        }
        songs = output;
    }
    
    public void removeSongByName(String songName)
    {
        int sl = songs.length;
        Song[] output = new Song[sl-1];
        int songfound = 0;
        for(int i = 0; i < songs.length; i ++)
        {
            if((songs[i].songName).equals(songName))
            songfound ++;
            else
            output[i-songfound] = songs[i];
        }
        songs = output;
    }
    
    //helpers
    
    public Song[] getSongs()
    {
        return this.songs;
    }
    
    public String getName()
    {
        return this.artistName;
    }
    
    public boolean equals(Artist other)
    {
        return this.artistName.equals(other.artistName);
    }
}
