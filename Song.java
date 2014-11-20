public class Song
{
    private Artist artist;
    public String songName;
    public long date;
    public Song(String songName, Artist artist)
    {
        this.songName = songName;
        this.artist = artist;
    }
    
    //helper
    
    public boolean equals( Song other)
    {
        return this.songName.equals(other.songName);
    }
    
    
    public Artist getArtist()
    {
        return this.artist;
    }
}
