# Stant UI Android Library

## Increase Decrease Buttons View
> A custom view to action increase and decrease buttons styleable with +/- icons.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/increasedecreasebuttonsview/doc/increase_decrease_buttons.jpg"  width="56">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Add component to view file with your string view variable choosing card style that you want .
```xml
        <br.com.stant.libraries.uilibrary.components.increasedecreasebuttonsview.IncreaseDecreaseButtonsView
            android:layout_width="60dp"
            android:layout_height="wrap_content"/>
```

3. Set action when on click button .
```java
    increaseDecreaseButtonsView.setOnPressDecreaseButton(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            //set decrease action button
        }
    });

    increaseDecreaseButtonsView.setOnPressIncreaseButton(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            //set increase action button

        }
    });
```
