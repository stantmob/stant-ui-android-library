# Stant UI Android Library

## Select Time Picker 
> A custom card with time format and a dialog opened when it clicks on time.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/selecttimepickerview/doc/select_time_picker.png"  width="59">
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/selecttimepickerview/doc/select_time_picker_time_number_picker_dialog.png"  width="268">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable, they will correspond for the string value for time shown.
```xml
    <data>
         <variable
             name="timeText"
             type="String" />
    </data>
```

3. Add component to view file with your strings view variable.
```xml
        <br.com.stant.libraries.uilibrary.components.selecttimepickerview.selectTimePickerView
                    android:id="@+id/select_time_picker"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:timeText = "{@timeText}"/>
```

4. Text setting can also be done using databinding on Activity or Fragment.
```java
    mSelectTimePickerViewBinding.setTime("00:00");
```