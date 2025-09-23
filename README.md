# LoadingDialog

A simple and customizable **loading dialog** library for Android.  
Easily show a progress dialog with optional title and message in any Activity or Fragment.

---

## Features

- Customizable **title** and **message**
- Non-cancelable or cancelable dialogs
- Easy to integrate and use
- Lightweight and dependency-free

---

## Installation

Add the JitPack repository to your project:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
````

Add the dependency:

```gradle
dependencies {
    implementation 'com.github.Ashadujjaman50:loadingdialog:1.0.0'
}
```


---

## Usage

### Initialize

```java
LoadingDialog loadingDialog = new LoadingDialog(this);
```

### Show the dialog

```java
loadingDialog.show();
```

### Set optional title and message

```java
loadingDialog.setTitle("Please wait");
loadingDialog.setMessage("Uploading...");
```

### Hide the dialog

```java
loadingDialog.dismiss();
```

### Make dialog cancelable

```java
loadingDialog.setCancelable(true); // or false
```

---

## Example

```java
LoadingDialog loadingDialog = new LoadingDialog(this);
loadingDialog.setTitle("Loading");
loadingDialog.setMessage("Please wait while we process your request...");
loadingDialog.show();

// Dismiss after task completion
loadingDialog.dismiss();
```

---

## Customization

The dialog uses a simple layout (`dialog_loading.xml`) with:

* `TextView` for **title** (`@id/loading_title`)
* `TextView` for **message** (`@id/loading_message`)
* `ProgressBar` (`@id/loading_progress`)

You can edit the XML layout to match your app theme and design.

---

## License

MIT License © \[Ashadujjaman50]

