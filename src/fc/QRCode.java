package fc;
public class QRCode extends Support {

	QRCode(Film f) {
		super(f);
		//TODO Auto-generated constructor stub
	}
    
    void sortir_support(){
        automate.sortir_QRcode(film.get_id());
    }
}
