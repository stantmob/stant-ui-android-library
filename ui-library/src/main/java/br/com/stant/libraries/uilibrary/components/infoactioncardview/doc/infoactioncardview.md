# Stant UI Android Library

## Info Action Card 
> A custom card with a title and a button to execute some action.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/infoactioncardview/doc/info_action_card.png"  width="430">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable, they will correspond for the string value for title and action.
```xml
    <data>
             <variable
                name="infoText"
                type="String"/>
    
            <variable
                name="actionText"
                type="String"/>
        </data>
```

3. Add component to view file with your strings view variable. 
```xml
        <br.com.stant.libraries.uilibrary.components.infoactioncardview.InfoActionCardView
                    android:id="@+id/info_action_card"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    app:infoText = "@{infoText}"
                    app:actionText = "@{actionText}"/>
```

4. Text setting can also be done using databinding on Activity or Fragment.
```java
    mInfoActionCardViewBinding.setInfoText("Information text");
    mInfoActionCardViewBinding.setActionText("Button action text");
```

5. For setting the action of button, use setOnClickActionCardListener method.
```java
    infoActionCardView.setOnClickActionCardListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //action to be executed on button clicking
        }
    });
```