Create or replace trigger NbEnfant
Before delete or insert on AbonneEnfant
for each row
Begin 
	if (deleting) then
		update AbonneParent Set nbEnfant = nbEnfant-1 
							where noClient = :old.noParent;
	else
		update AbonneParent Set nbEnfant = nbEnfant+1 
							where noClient = :new.noParent;
	end if;
End;
/

Create or replace trigger LocationFilm
Before insert on Location
for each row
Begin 
	if ((Select Count(noClient) from Location 
							where retourne = 0 and noSupport = :new.noSupport 
							group by noSupport) != 0) then
		raise_application_error(-20001, 'Support indisponible')
	end if

    update Film Set nbLoue = nbLoue+1 
				where noFilm = (distinct noFilm from Support 
												where noSupport = :new.noSupport);
	
    if ((select typeCarte from Client 
						where noClient = :new.noClient) = 'Sans Carte') then
		update CarteBancaire set dateUtil = :new.dateEmprunt 
							where noClient = :new.noClient;
	end if;
End;
/


