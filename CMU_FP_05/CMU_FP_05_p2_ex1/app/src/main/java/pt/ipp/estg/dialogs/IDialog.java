package pt.ipp.estg.dialogs;

import androidx.fragment.app.DialogFragment;

public interface IDialog {
    public void onDialogPositiveClick(DialogFragment dialog);
    public void onDialogNegativeClick(DialogFragment dialog);
}
