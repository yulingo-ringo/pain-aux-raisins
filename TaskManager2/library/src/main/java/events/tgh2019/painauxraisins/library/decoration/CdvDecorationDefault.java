package events.tgh2019.painauxraisins.library.decoration;


import android.content.Context;
import android.graphics.Rect;
import events.tgh2019.painauxraisins.library.DayView;
import events.tgh2019.painauxraisins.library.EventView;
import events.tgh2019.painauxraisins.library.PopupView;
import events.tgh2019.painauxraisins.library.data.IEvent;
import events.tgh2019.painauxraisins.library.data.IPopup;

/**
 * Created by FRAMGIA\pham.van.khac on 22/07/2016.
 */
public class CdvDecorationDefault implements CdvDecoration {

    protected Context mContext;

    protected EventView.OnEventClickListener mEventClickListener;

    protected PopupView.OnEventPopupClickListener mPopupClickListener;

    public CdvDecorationDefault(Context context) {
        this.mContext = context;
    }

    @Override
    public EventView getEventView(IEvent event, Rect eventBound, int hourHeight,
                                  int separateHeight) {
        EventView eventView = new EventView(mContext);
        eventView.setEvent(event);
        eventView.setPosition(eventBound, -hourHeight, hourHeight - separateHeight * 2);
        eventView.setOnEventClickListener(mEventClickListener);
        return eventView;
    }

    @Override
    public PopupView getPopupView(IPopup popup, Rect eventBound, int hourHeight, int seperateH) {
        PopupView view = new PopupView(mContext);
        view.setOnPopupClickListener(mPopupClickListener);
        view.setPopup(popup);
        view.setPosition(eventBound, -hourHeight / 4 + seperateH, hourHeight / 2 - seperateH * 2);
        return view;
    }

    @Override
    public DayView getDayView(int hour) {
        DayView dayView = new DayView(mContext);
        dayView.setText(String.format("%1$2s:00", hour));
        return dayView;
    }

    public void setOnEventClickListener(EventView.OnEventClickListener listener) {
        this.mEventClickListener = listener;
    }

    public void setOnPopupClickListener(PopupView.OnEventPopupClickListener listener) {
        this.mPopupClickListener = listener;
    }
}
