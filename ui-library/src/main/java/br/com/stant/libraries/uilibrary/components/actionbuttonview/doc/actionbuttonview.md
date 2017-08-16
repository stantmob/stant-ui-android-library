# Stant UI Android Library

## Action Button View
> A custom view to expand and hidden big texts with simple button.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/actionbuttonview/doc/action-button-vertical.jpg" >
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/actionbuttonview/doc/action-button-horizontal.jpg" >
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Add component to view file with your string view variable choosing card style that you want .
```xml
    <br.com.stant.libraries.uilibrary.components.actionbuttonview.ActionButtonView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="4"
        app:actionText="@string/your_action_text_string"
        app:actionIcon="@drawable/your_image_icon"
        app:cardStyle="vertical|horizontal"
        />
```



3. Set action when on click button .
```java
    mServiceInspectionFormFilledDetailFragBinding.serviceInspectionFormFilledDetailApproveSiffActionButtonView.
            setOnClickActionButtonListener(new ActionButtonViewContract.OnClickActionButtonListener() {
                @Override
                public void onClick() {
                    //  put your actions here
                }
            });
```