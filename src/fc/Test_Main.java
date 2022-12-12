package fc;

public class Test_Main {
    public static void main(String argv[]){

        Test_Film test_film = new Test_Film();
        test_film.test();

        Test_QRCode test_qrcode = new Test_QRCode();
        test_qrcode.test();

        Test_DVD test_dvd = new Test_DVD();
        test_dvd.test();

        Test_Abonne_Parent test_abonne_parent = new Test_Abonne_Parent();
        test_abonne_parent.test();

        Test_Abonne_Enfant test_abonne_enfant = new Test_Abonne_Enfant();
        test_abonne_enfant.test();
      
        Test_Location test_location = new Test_Location();
        test_location.test();
        
        Test_Carte_Banquaire test_carte_banquaire = new Test_Carte_Banquaire();
        test_carte_banquaire.test(false);
        
        Test_Client test_client = new Test_Client();
        test_client.test();

        return;
        
    }
}
