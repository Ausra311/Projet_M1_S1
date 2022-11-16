Create or replace trigger NbEnfant
Before delete or insert on AbonneEnfant
for each row
Begin 
	if (deleting) then
		update AbonneParent Set nbEnfant = nbEnfant-1 where noClient = :old.noParent;
	else
		update LesAnimaux Set nbEnfant = nbEnfant+1 where noClient = :old.noParent;
	end if;
End;
/

Create or replace trigger LocationFilm
Before insert on Location
for each row
Begin 
    update Film Set nbLoue = nbLoue+1 where noFilm = (distinct noFilm from Support where noSupport = :old.noParent);
    
End;
/


