# Stant UI Android Library

## Executed Percent Bar 
> A custom dinamic bar that shows the percentage executed.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/executedpercentbarview/doc/executed_percent_bar.png"  width="270">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable, they will correspond for the string value for description and percentage.
```xml
    <data>
            <variable
                name="percentDescriptionPt1"
                type="String"/>
            <variable
                name="percentDescriptionPt2"
                type="String"/>
            <variable
                name="percentValuePt1"
                type="String"/>
            <variable
                name="percentValuePt2"
                type="String"/>
        </data>
```

3. Add component to view file with your strings view variable. In case you want to use library component as it is shown, you don't need to send this parameters. 
```xml
        <br.com.stant.libraries.uilibrary.components.executedpercentbarview.ExecutedPercentBarView
                    android:id="@+id/executed_percent_bar"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    app:percentDescriptionPt1 = "@{percentDescriptionPt1}"
                    app:percentDescriptionPt2 = "@{percentDescriptionPt2}"
                    app:percentValuePt1 = "@{percentValuePt1}"
                    app:percentValuePt2 = "@{percentValuePt2}"/>
```

4. Set percentage to be shown on your Activity or Fragment.
```java
   executedPercentBarView.setPercentValue(70);      
```
