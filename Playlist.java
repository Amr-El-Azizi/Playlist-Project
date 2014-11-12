public class Playlist
{
    private String listName;
    private Song[] songs;
    private int[] stars;
    public Playlist(String listName)
    {
        this.listName = listName;
    }
    
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
            if(getArtist(songs[i]).equals(artist))
            starssum += stars[i];
        }
    }
}
