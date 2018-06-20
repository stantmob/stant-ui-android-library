# Stant UI Android Library

## Action Button View
> A custom view to action button styleable with icon.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/actionbuttonview/doc/action-button-vertical.jpg"  width="150">
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/actionbuttonview/doc/action-button-horizontal.jpg"  width="350">
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
    mBinding.actionButtonView.
            setOnClickActionButtonListener(new ActionButtonViewContract.OnClickActionButtonListener() {
                @Override
                public void onClick() {
                    //  put your actions here
                }
            });
```
