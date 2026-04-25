package com.ashadujjaman.loadingdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingDialog {
    private AlertDialog dialog;
    private TextView tvTitle, tvMessage;
    private ProgressBar progressBar;

    private final Context context;
    private String title;
    private String message;
    private boolean progressBarShown = true;
    private boolean cancelable = false;
    private boolean canceledOnTouchOutside = false;
    private int themeResId = R.style.Theme_LoadingDialog_Default;

    public LoadingDialog(Context context) {
        this.context = context;
    }

    private void create() {
        Context themedContext = new ContextThemeWrapper(context, themeResId);
        View view = LayoutInflater.from(themedContext).inflate(R.layout.dialog_loading, null);

        tvTitle = view.findViewById(R.id.loading_title);
        tvMessage = view.findViewById(R.id.loading_message);
        progressBar = view.findViewById(R.id.loading_progress);

        dialog = new AlertDialog.Builder(themedContext)
                .setView(view)
                .create();

        // Apply the stored properties
        setTitle(this.title);
        setMessage(this.message);
        setProgressBarShow(this.progressBarShown);
        setCancelable(this.cancelable);
        setCanceledOnTouchOutside(this.canceledOnTouchOutside);
    }

    public void setTheme(String theme) {
        if (theme == null) theme = "default";
        switch (theme.toLowerCase()) {
            case "horizontal":
                this.themeResId = R.style.Theme_LoadingDialog_Horizontal;
                break;
            case "small":
                this.themeResId = R.style.Theme_LoadingDialog_Small;
                break;
            case "large":
                this.themeResId = R.style.Theme_LoadingDialog_Large;
                break;
            case "inverse":
                this.themeResId = R.style.Theme_LoadingDialog_Inverse;
                break;
            case "small_inverse":
                this.themeResId = R.style.Theme_LoadingDialog_Small_Inverse;
                break;
            case "large_inverse":
                this.themeResId = R.style.Theme_LoadingDialog_Large_Inverse;
                break;
            default:
                this.themeResId = R.style.Theme_LoadingDialog_Default;
                break;
        }

        if (dialog != null) {
            boolean wasShowing = dialog.isShowing();
            dialog.dismiss();
            create();
            if (wasShowing) {
                dialog.show();
            }
        }
    }

    public void show() {
        if (dialog == null) {
            create();
        }
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public void dismiss() {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title) {
        this.title = title;
        if (tvTitle != null) {
            if (title != null && !title.isEmpty()) {
                tvTitle.setText(title);
                tvTitle.setVisibility(View.VISIBLE);
            } else {
                tvTitle.setVisibility(View.GONE);
            }
        }
    }

    public void setMessage(String message) {
        this.message = message;
        if (tvMessage != null) {
            if (message != null && !message.isEmpty()) {
                tvMessage.setText(message);
                tvMessage.setVisibility(View.VISIBLE);
            } else {
                tvMessage.setVisibility(View.GONE);
            }
        }
    }

    public void setProgressBarShow(boolean show) {
        this.progressBarShown = show;
        if (progressBar != null) {
            progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        if (dialog != null) {
            dialog.setCancelable(cancelable);
        }
    }

    public void setCanceledOnTouchOutside(boolean cancel) {
        this.canceledOnTouchOutside = cancel;
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(cancel);
        }
    }
}
