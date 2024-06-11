insert into QUESTION (STRIKES, TEXT) values (0, '3rd baseman asks for and gets time.  He confers with the pitcher and returns to 3rd base with the ball.  R3 steps off the bag and is tagged out by the 3rd baseman.');
insert into QUESTION (STRIKES, TEXT) values (0, 'Runner on 2nd steals third.  The pitch hits the batter and rolls away allowing the runner to continue and score.');
insert into User(lastName, firstName, username, password) values ( 'Janssens', 'Bram', 'bram', 'ADBBiieKz0G43fGALhxt84HX9hIZMWe/XQCNUpnmywE='); -- pw = bram
insert into User_ROLES (User_ID, ROLES) values (1, 'USER');
insert into User(lastName, firstName, username, password) values ( 'Ministrator', 'Ad', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg='); -- pw = admin
insert into User_ROLES (User_ID, ROLES) values (2, 'USER');
insert into User_ROLES (User_ID, ROLES) values (2, 'ADMIN');
