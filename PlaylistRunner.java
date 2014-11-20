public class PlaylistRunner
{
    public PlaylistRunner()
    {
        Playlist testdummy2 = new Playlist("testdumy2");
        Artist testdummy = new Artist("testdummy");
        Artist fakedummy = new Artist("fakedummy");
        System.out.println(testdummy2.averageRating());
        System.out.println(testdummy2.averageRating(testdummy));
        print(testdummy2.getSongs(testdummy), testdummy2.getStars());
        print(testdummy2.getSongs(), testdummy2.getStars());
        testdummy2.swap(new Song("Song 1", testdummy), new Song("Song 2", testdummy));
        print(testdummy2.getSongs(), testdummy2.getStars());
        testdummy2.addSong(new Song("Song 4", testdummy), 1);
        print(testdummy2.getSongs(), testdummy2.getStars());
        testdummy2.removeSong(new Song("Song 2", testdummy), "testdummy");
        print(testdummy2.getSongs(), testdummy2.getStars());
        testdummy2.removeArtist(fakedummy);
        print(testdummy2.getSongs(), testdummy2.getStars());
        testdummy2.removeLowStars(3);
        print(testdummy2.getSongs(), testdummy2.getStars());
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
