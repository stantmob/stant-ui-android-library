# Stant UI Android Library

## Information Card 
> A custom card with a title, type, two dates and a severity level indicator.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/informationcardview/doc/information_card_view.png"  width="315">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable, they will correspond for the string value for title, type, the two dates and the actions indicator.
```xml
    <data>
             <variable
                 name="createdAt"
                 type="String" />
     
             <variable
                 name="title"
                 type="String" />
     
             <variable
                 name="type"
                 type="String" />
     
             <variable
                 name="deadline"
                 type="String" />
     
             <variable
                 name="actions"
                 type="String" />
        </data>
```

3. Add component to view file with your strings view variable. 
```xml
        <br.com.stant.libraries.uilibrary.components.informationcardview.InformationCardView
           android:id="@+id/information_card_view"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" 
           app:createdAt = "@{createdAt}" 
           app:title = "@{title}" 
           app:type = "@{type}" 
           app:deadline = "@{deadline}" 
           app:actions = "@{actions}" />
           
```

4. Text setting can also be done using databinding on Activity or Fragment.
```java
    mInformationCardViewBinding.setTitle(title);
    mInformationCardViewBinding.setType(type);
    mInformationCardViewBinding.setActions(actions);
    mInformationCardViewBinding.setCreatedAt(createdAt);
    mInformationCardViewBinding.setDeadline(deadline);
```