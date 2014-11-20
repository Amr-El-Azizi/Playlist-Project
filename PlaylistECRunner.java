public class PlaylistECRunner
{
    public PlaylistECRunner()
    {
        Playlist testdummy2 = new Playlist("testdumy2");
        Artist testdummy = new Artist("testdummy");
        Artist fakedummy = new Artist("fakedummy");
        print(testdummy2.getSongs(), testdummy2.getStars());
        print(testdummy2.sortByRating().getSongs(), testdummy2.sortByRating().getStars());
    }
    
    //helpers
    
    public void print(Song[] Song)
    {
        for( Song aSong: Song)
        print(aSong);
        System.out.println();
    }
    
    public void print(Song[] Song, int[] Stars)
    {
        int snl = Song.length;
        for(int i = 0; i < snl; i ++)
        {
            print(Song[i]);
            System.out.print(Stars[i] + "\t");
        }
        System.out.println();
    }
    
    public void print(Song Song)
    {
        System.out.print(Song.songName + "\t");
        print(Song.getArtist());
        System.out.print("\t");
    }
    
    public void print(Artist Artist)
    {
        System.out.print(Artist.getName());
    }
}
