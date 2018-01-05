# Stant UI Android Library

## Button Component
> A custom view to action button with shadow.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/buttoncomponent/doc/button_component.jpeg"  width="350">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Add component to view file setting custom components (button text, shape and shadow shape) as you want.
   Note that buttonShape and buttonShadowShape are drawable shapes.
```xml

     <br.com.stant.libraries.uilibrary.components.buttoncomponent.ButtonComponentView
                android:id="@+id/button_component"
                android:layout_width="match_parent"
                app:buttonText="@{buttonText}"
                app:buttonShape="@{buttonShape}"
                app:buttonShadowShape="@{buttonShadowShape}"
                android:layout_height="57dp"/>

```

3. Set action when on click button .
```java

    mBinding.buttonComponent.
            setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //  put your actions here
                }
            });

```

4. Set Inactive State on Button

```java

    mSampleWorkspaceActBinding.buttonComponent.setInactiveStatusOnButton();

```

5. Returning to Active State on Button

```java

    mSampleWorkspaceActBinding.buttonComponent.setActiveStatusOnButton(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(WorkspaceActivity.this, "Actived Again", Toast.LENGTH_SHORT).show();
        }
    });

```
