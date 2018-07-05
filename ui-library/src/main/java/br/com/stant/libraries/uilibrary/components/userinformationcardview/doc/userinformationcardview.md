# Stant UI Android Library

## User Information Card 
> A custom card with name, role, a photo field and a badge.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/userinformationcardview/doc/user_information_card.png"  width="120">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable, they will correspond for the string value for name, role, type, photo and control of the badge (its visibility and icon).
```xml
    <data>
            <variable
                name="name"
                type="String" />
    
            <variable
                name="role"
                type="String" />
    
            <variable
                name="type"
                type="String" />
    
            <variable
                name="photo"
                type="String" />
    
            <variable
                name="badgeIcon"
                type="android.graphics.drawable.Drawable" />
    
            <variable
                name="visibility"
                type="int" />
        </data>
```

3. Add component to view file with your strings view variable. 
```xml
        <br.com.stant.libraries.uilibrary.components.userinformationcardview.UserInformationCardView
            android:id="@+id/user_information_card_view"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" 
            app:name = "@{name}"
            app:role = "@{role}"
            app:type = "@{type}"
            app:photo = "@{photo}"
            app:badgeIcon = "@{badgeIcon}"
            app:visibility = "@{visibility}"/>
           
```

4. Setting can also be done using databinding on Activity or Fragment.
```java
     mUserInformationCardViewBinding.userInformationCardView.setUserName(name);
     mUserInformationCardViewBinding.userInformationCardView.setUserRole(role);
     mUserInformationCardViewBinding.userInformationCardView.setUserType(type);
     mUserInformationCardViewBinding.userInformationCardView.setUserPhoto(photo);
```

5. If your badge should be visible, also add icon settings with databinding.
```java
     mUserInformationCardViewBinding.userInformationCardView.setBadgeEnable(badgeIcon);
```
5. If your badge should not be visible, set it disable with databinding.
```java
     mUserInformationCardViewBinding.userInformationCardView.setBadgeDisable();
```