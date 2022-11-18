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

	if ((select typeCarte from Client 
							where noClient = :new.noClient) = 'Sans Carte') then
			
			if ((Select count(noSupport) from Location
										where noClient = :new.noClient and retourne = 1
										group by noClient) != 0) then
				raise_application_error(-20002, 'Trop de film en location');
			end if;

			update CarteBancaire set dateUtil = :new.dateEmprunt 
								where noClient = :new.noClient;
	else
		if ((Select count(noSupport) from Location
										where noClient = :new.noClient and retourne = 1
										group by noClient) > 2) then
			raise_application_error(-20002, 'Trop de film en location');
		end if;
		if ((Select solde from Abonne where noClient = :new.noClient) > 14) then
			raise_application_error(-20003, 'Solde insuffisant');
		end if;
	end if;

    update Film Set nbLoue = nbLoue+1 
				where noFilm = (distinct noFilm from Support 
												where noSupport = :new.noSupport);
	
    
End;
/

Create or replace trigger RechargeCompte
before update on Abonne
for each row
Begin
	if (:new.solde < 10) then
		raise_application_error(-20004, 'Recharge insuffisante');
	end if;
End;
/

