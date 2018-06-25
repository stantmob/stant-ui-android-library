# Stant UI Android Library

## Select Date Picker 
> A custom card with date format and a calendar icon.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/selectdatepickerview/doc/select_date_picker.png"  width="130">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable, they will correspond for the string value for date shown.
```xml
    <data>
         <variable
             name="date"
             type="String" />
    </data>
```

3. Add component to view file with your strings view variable.
```xml
        <br.com.stant.libraries.uilibrary.components.selectdatepickerview.selectDatePickerView
            android:id="@+id/select_date_picker"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:date = "@{date}"/>
```

4. Text setting can also be done using databinding on Activity or Fragment.
```java
    mSelectDatePickerViewBinding.setDate("00/00/00");
```