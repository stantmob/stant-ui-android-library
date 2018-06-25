# Stant UI Android Library

## Simple Request Info Snackbar 
> A custom snackbar with messages of success or fail.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/simplerequestinfosnackbar/doc/simple_request_info_snackbar_fail.png"  width="305">
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/simplerequestinfosnackbar/doc/simple_request_info_snackbar_success.png"  width="305">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Add component on your Activity or Fragment, setting context, view, message to be shown and Enum type (Success or fail).
Usually this the result of an action of another clickable element from your project.
```java
  SimpleRequestInfoSnackbar snackbar = new SimpleRequestInfoSnackbar(WorkspaceActivity.this, mBinding.getRoot(), "Message", SimpleRequestInfoSnackbarTypeEnum.SUCCESS);
  snackbar.showSnackbar();
```
