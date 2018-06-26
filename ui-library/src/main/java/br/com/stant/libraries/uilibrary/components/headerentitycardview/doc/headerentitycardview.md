# Stant UI Android Library

## Header Entity Card 
> A custom card with a title, two dates and two quantities indicators.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/headerentitycardview/doc/header_entity_card_view.png"  width="320">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable, they will correspond for the string value for title, type, the two dates and the actions indicator.
```xml
    <data>
             <variable
                 name="startAt"
                 type="String" />
     
             <variable
                 name="title"
                 type="String" />
     
             <variable
                 name="endAt"
                 type="String" />
     
             <variable
                 name="quantity1"
                 type="String" />
     
             <variable
                 name="quantity2"
                 type="String" />
        </data>
```

3. Add component to view file with your strings view variable. 
```xml
        <br.com.stant.libraries.uilibrary.components.headerentitycardview.HeaderEntityCardView
           android:id="@+id/header_entity_card_view"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" 
           app:startAt = "@{startAt}"
           app:title = "@{title}"
           app:endAt = "@{endAt}"
           app:quantity1 = "@{quantity1}"
           app:quantity2 = "@{quantity2}"/>
           
```

4. Text setting can also be done using databinding on Activity or Fragment.
```java
    mHeaderEntityCardViewBinding.setTitle(title);
    mHeaderEntityCardViewBinding.setEndAt(endAt);
    mHeaderEntityCardViewBinding.setStartAt(startAt);
    mHeaderEntityCardViewBinding.setFirstQuantity(firstQuantity);
    mHeaderEntityCardViewBinding.setSecondQuantity(secondQuantity);
```