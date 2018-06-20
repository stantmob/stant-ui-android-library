# Stant UI Android Library

## Simple Information Card 
> A custom card with two status that can be changed.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/simpleinformationscardview/doc/simple_informations_card_first_state.png"  width="435">
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/simpleinformationscardview/doc/simple_informations_card_second_state.png"  width="440">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable.
```xml
    <data>
            <variable
                name="firstTitle"
                type="String"/>
            <variable
                name="firstValue"
                type="String"/>
            <variable
                name="secondTitle"
                type="String"/>
            <variable
                name="secondValue"
                type="String"/>
            <variable
                name="informationsColor"
                type="Integer"/>
    </data>
```

3. Add component to view file with your strings view variable.  
```xml
        <br.com.stant.libraries.uilibrary.components.simpleinformationcardview.SimpleInformationCardView
            android:id="@+id/simple_information_card"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            app:firstTitle = "@{firstTitle}"
            app:firstValue = "@{firstValue}"
            app:secondTitle = "@{secondTitle}"
            app:secondValue = "@{secondValue}"
            app:informationsColor = "@{informationsColor}"/>
```

4. Text setting can also be done using databinding on Activity or Fragment.
```java
    mSimpleInformationCardViewBinding.setFirstTitle("Text");
    mSimpleInformationCardViewBinding.setFirstValue("Text");
    mSimpleInformationCardViewBinding.setSecondTitle("Text");
    mSimpleInformationCardViewBinding.setSecondValue("Text");
    mSimpleInformationCardViewBinding.setInformationsColor("Color");
```
