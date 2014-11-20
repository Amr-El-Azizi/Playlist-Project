public class ArtistRunner
{
    public ArtistRunner()
    {
        Artist testdummy = new Artist("testdummy");
        print(testdummy.getSongs());
        System.out.println(testdummy.indexOf("Song 1"));
        testdummy.addSong(new Song("Song 4", testdummy));
        print(testdummy.getSongs());
        testdummy.removeSong(new Song("Song 3", testdummy));
        print(testdummy.getSongs());
        testdummy.removeSongByName("Song 1");
        print(testdummy.getSongs());
        System.out.println(testdummy.getName());
    }
    
    
    //helpers
    
    public void print(Song[] Song)
    {
        for( Song aSong: Song)
        print(aSong);
        System.out.println();
    }
    
    public void print(Song Song)
    {
        System.out.print(Song.songName + "\t");
        print(Song.getArtist());
        System.out.print("\t");
        System.out.print(Song.date + "\t");
    }
    
    public void print(Artist Artist)
    {
        System.out.print(Artist.getName());
    }
}
