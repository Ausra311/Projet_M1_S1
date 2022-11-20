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
declare 
	nb integer;
	Carte varchar2(20);
Begin 
	Select Count(*) into nb from Location 
		where retourne = 0 and noSupport = :new.noSupport;
	if (nb != 0) then
		raise_application_error(-20001, 'Support indisponible');
	end if;

	select typeClient into Carte from Client 
		where noClient = :new.noClient;
	if ( Carte = 'Sans Carte') then
			
			Select count(*) into nb from Location
				where noClient = :new.noClient and retourne = 0;
			if (nb != 0) then
				raise_application_error(-20002, 'Trop de film en location');
			end if;

		update CarteBancaire set dateUtil = :new.dateEmprunt 
			where noClient = :new.noClient;
	else
		Select count(*) into nb from Location
			where noClient = :new.noClient and retourne = 0;
		if (nb > 2) then
			raise_application_error(-20002, 'Trop de film en location');
		end if;

		Select solde into nb from Abonne 
			where noClient = :new.noClient;
		if (nb < 15) then
			raise_application_error(-20003, 'Solde insuffisant');
		end if;
	end if;

    update Film Set nbLoue = nbLoue+1 
		where noFilm = (select distinct noFilm from Support 
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

Create or replace trigger CreationCompte
before insert on Abonne
for each row
Begin
	if (:new.solde < 15) then
		raise_application_error(-20004, 'Solde de depart insuffant');
	end if;
End;
/

Create or replace trigger NvlCarteBancaire
before insert on CarteBancaire
for each row
declare 
	nb integer;
Begin
	select count(noClient) into nb from CarteBancaire 
		where nomBanque = :new.nomBanque and typeCarte = :new.typeCarte and refBancaire = :new.refBancaire;

End;
/