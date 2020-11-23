/**
 * 마커 커스텀 1 IconGenerator
 */

public class IconGeneratorUtil extends IconGenerator {
    private Context mContext;

    private ViewGroup mContainer;
    private RotationLayout mRotationLayout;
    private TextView mTextView;
    private View mContentView;
    private int mRotation;

    private static final int[][] TYPE_NORMAL_IMAGES = {
        {R.drawable.ico_text_balloon1, R.style.Bubble_TextAppearance_Pagl},     // type1
        {R.drawable.ico_text_balloon2, R.style.Bubble_TextAppearance_Park},     // type2
        {R.drawable.ico_text_balloon1, R.style.Bubble_TextAppearance_Pagl},     // type3
        {R.drawable.ico_text_balloon3, R.style.Bubble_TextAppearance_Zone},     // type4
        {R.drawable.ico_text_balloon4, R.style.Bubble_TextAppearance_Valet},    // type5
    };
    private static final int[][] TYPE_PRESS_IMAGES = {
        {R.drawable.ico_text_balloon1_pressed, R.style.Bubble_TextAppearance_Pagl_Press},     // type1
        {R.drawable.ico_text_balloon2_pressed, R.style.Bubble_TextAppearance_Park_Press},     // type2
        {R.drawable.ico_text_balloon1_pressed, R.style.Bubble_TextAppearance_Pagl_Press},     // type3
        {R.drawable.ico_text_balloon3_pressed, R.style.Bubble_TextAppearance_Zone_Press},     // type4
        {R.drawable.ico_text_balloon4_pressed, R.style.Bubble_TextAppearance_Valet_Press},    // type5
    };

    public IconGeneratorUtil(Context context, int type, Boolean isElectricCharge, boolean isPressed) {
        super(context);
        mContext = context;

        mContainer = (ViewGroup) LayoutInflater.from(mContext).inflate(!isElectricCharge ? R.layout.text_bubble : R.layout.text_bubble_electric_charge, null);
        mRotationLayout = (RotationLayout) mContainer.getChildAt(0);
        mContentView = mTextView = mRotationLayout.findViewById(R.id.text);

        if (!isElectricCharge) {
            mContainer.setBackgroundResource(!isPressed ? TYPE_NORMAL_IMAGES[type][0] : TYPE_PRESS_IMAGES[type][0]);
        } else {
            mRotationLayout.setBackgroundResource(!isPressed ? TYPE_NORMAL_IMAGES[type][0] : TYPE_PRESS_IMAGES[type][0]);
        }
        mTextView.setTextAppearance(mContext, !isPressed ? TYPE_NORMAL_IMAGES[type][1] : TYPE_PRESS_IMAGES[type][1]);
    }

    /**
     * Sets the text content, then creates an icon with the current style.
     * @param text the text content to display inside the icon.
     */
    public Bitmap makeIcon(String text) {
        if (mTextView != null) {
            mTextView.setText(text);
        }

        return makeIcon();
    }

    /**
     * Creates an icon with the current content and style.
     * <p/>
     * This method is useful if a custom view has previously been set, or if
     * text content is not applicable.
     */
    public Bitmap makeIcon() {
        int measureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mContainer.measure(measureSpec, measureSpec);

        int measuredWidth = mContainer.getMeasuredWidth();
        int measuredHeight = mContainer.getMeasuredHeight();

        mContainer.layout(0, 0, measuredWidth, measuredHeight);

        if (mRotation == 1 || mRotation == 3) {
            measuredHeight = mContainer.getMeasuredWidth();
            measuredWidth = mContainer.getMeasuredHeight();
        }

        Bitmap r = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        r.eraseColor(Color.TRANSPARENT);

        Canvas canvas = new Canvas(r);

        if (mRotation == 0) {
            // do nothing
        } else if (mRotation == 1) {
            canvas.translate(measuredWidth, 0);
            canvas.rotate(90);
        } else if (mRotation == 2) {
            canvas.rotate(180, measuredWidth / 2, measuredHeight / 2);
        } else {
            canvas.translate(0, measuredHeight);
            canvas.rotate(270);
        }
        mContainer.draw(canvas);
        return r;
    }

    @Override
    public void setContentView(View contentView) {
        mRotationLayout.removeAllViews();
        mRotationLayout.addView(contentView);
        mContentView = contentView;
        final View view = mRotationLayout.findViewById(R.id.text);
        mTextView = view instanceof TextView ? (TextView) view : null;
    }

    @Override
    public void setStyle(int style) {
    }

    @Override
    public void setTextAppearance(int resid) {
    }

    @Override
    public void setColor(int color) {
    }

    @Override
    public void setBackground(Drawable background) {
        mContainer.setBackgroundDrawable(background);

        if (background != null) {
            Rect rect = new Rect();
            background.getPadding(rect);
            mContainer.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        } else {
            mContainer.setPadding(0, 0, 0, 0);
        }
    }

    @Override
    public void setContentPadding(int left, int top, int right, int bottom) {
        mContentView.setPadding(left, top, right, bottom);
    }
}

/**
 * 마커 커스텀 2 IconGenerator
 */

public class IconGeneratorYJH extends IconGenerator {

    private Context mContext;

    IconGeneratorYJH(Context context, int type) {
        super(context);
        this.mContext = context;

        switch (type) {
            case STYLE_PAGL:
                setBackground(UtilYJH.getDrawable(mContext, R.drawable.ic_textmarker));
                break;
            case STYLE_ZONE:
                setBackground(UtilYJH.getDrawable(mContext, R.drawable.ic_textmarker_parking));
                break;
            case STYLE_SELECTED:
                setBackground(UtilYJH.getDrawable(mContext, R.drawable.ic_textmarker_parking_selected));
                break;
        }
        setStyle(type);
    }

    @Override
    public void setStyle(int style) {
        if (mContext != null)
            setTextAppearance(mContext, getTextStyle(style));
    }
    static final int STYLE_PAGL = 8;
    static final int STYLE_ZONE = 10;
    static final int STYLE_SELECTED = 12;

    private static int getTextStyle(int style) {
        switch (style) {
            default:
            case STYLE_PAGL:
                return R.style.Bubble_TextAppearance_Pagl;
            case STYLE_ZONE:
                return R.style.Bubble_TextAppearance_Zone;
            case STYLE_SELECTED:
                return R.style.Bubble_TextAppearance_Selected;
        }
    }
}
