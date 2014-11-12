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
    
    
    public Artist getArtist()
    {
        return this.artist;
    }
}
