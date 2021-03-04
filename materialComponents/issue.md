## 1 CoordinatorLayout
- CoordinatorLayout 
 - AppBarLayout
  - CollapsingToolbarLayout
   - Toolbar
 - NestedScrollView : appbar_scrolling_view_behavior
   
이슈: nestedscrollview 안의 차일드뷰 에서 toobar size 초기진입시 계산하지 못함(pause ->  start시 다시 계산됨)
해결: minHeight 툴바 길이 지정
<com.google.android.material.appbar.CollapsingToolbarLayout
   android:minHeight="?attr/actionBarSize" or toobarsize
      