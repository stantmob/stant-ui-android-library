# Stant UI Android Library

## Viewing User Dialog 
> A custom dialog that shows a list of users, with name, role and photo.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/viewinguserdialog/doc/viewing_user_dialog.png"  width="300">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Add users to your list by creating ViewingUserDto and adding on a list of users.
```java
  List<ViewingUserDto> users;
  private void setUsers() {
      users = new ArrayList<>();
      users.add(new ViewingUserDto("User 1", null, "Role 1"));
      users.add(new ViewingUserDto("User 2", null, "Role 2"));
      users.add(new ViewingUserDto("User 3", null, "Role 3"));
  }
```

3. Configure your dialog on an Activity or Fragment using setViewingUsers method and passing the previous list as a parameter.
```java
   mViewingUsersDialog = new ViewingUsersDialog(this);
   mViewingUsersDialog.setViewingUsers(users);
```

4. Use show method to make dialog appear. Usually this the result of an action of another clickable element from your project.
```java
  mViewingUsersDialog.show();
```
