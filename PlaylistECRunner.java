public class PlaylistECRunner
{
    public PlaylistECRunner()
    {
        Playlist testdummy2 = new Playlist("testdumy2");
        Artist testdummy = new Artist("testdummy");
        Artist fakedummy = new Artist("fakedummy");
        print(testdummy2.getSongs(), testdummy2.getStars());
        Playlist newdummy = testdummy2.sortByRating();
        print(newdummy.getSongs(), newdummy.getStars());
        Playlist newdummy2 = testdummy2.shuffle();
        print(newdummy2.getSongs(), newdummy2.getStars());
        Playlist newdummy3 = newdummy2.sortByDate();
        print(newdummy3.getSongs(), newdummy3.getStars());
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
    
    public void print(Song song)
    {
        System.out.print(song.songName + "\t");
        print(song.getArtist());
        System.out.print("\t");
    }
    
    public void print(Artist Artist)
    {
        System.out.print(Artist.getName());
    }
}
