# LoadingDialog

A simple and customizable **loading dialog** library for Android.  
Easily show a progress dialog with optional title and message in any Activity or Fragment.

---

## Features

- Customizable **title** and **message**
- Customizable **ProgressBar** style
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
```

Add the dependency:

```gradle
dependencies {
    implementation 'com.github.Ashadujjaman50:loadingdialog:1.0.4'
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

### Make dialog setCanceledOnTouchOutside

```java
loadingDialog.setCanceledOnTouchOutside(true); // or false
```

### Make dialog cancelable

```java
loadingDialog.setCancelable(true); // or false
```

---

## ProgressBar Style Customization

You can change the `ProgressBar` style at runtime using the `setTheme()` method by passing a string.

### Set ProgressBar Style

```java
loadingDialog.setTheme("horizontal");
```

### Available Styles

Here are the available built-in styles:

| Theme String | Description |
| :--- | :--- |
| `"default"` | Medium circular progress bar (default) |
| `"horizontal"` | Horizontal progress bar |
| `"small"` | Small circular progress bar |
| `"large"` | Large circular progress bar |
| `"inverse"` | Inverse medium circular progress bar |
| `"small_inverse"` | Inverse small circular progress bar |
| `"large_inverse"` | Inverse large circular progress bar |


---

## Example

```java
// Initialize with default style
LoadingDialog loadingDialog = new LoadingDialog(this);
loadingDialog.setTitle("Loading");
loadingDialog.setMessage("Please wait...");
loadingDialog.show();

// You can change the style at any time using simple string names
// For example, change to a horizontal progress bar after 2 seconds
new Handler(Looper.getMainLooper()).postDelayed(() -> {
    loadingDialog.setTheme("horizontal");
    loadingDialog.setTitle("Processing...");
}, 2000);

// Dismiss after task completion
// loadingDialog.dismiss();
```

---

## License

License © [Ashadujjaman50]
