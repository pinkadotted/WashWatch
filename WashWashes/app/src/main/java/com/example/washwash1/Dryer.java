<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Washer">

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/bottom_navigation"
        app:menu="@menu/bottom_nav_menu"
        app:itemBackground="@color/colorPrimary"
        app:itemTextColor="@drawable/selector"
        app:itemIconTint="@drawable/selector"
        android:layout_alignParentBottom="true"/>

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="visible">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <GridLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:layout_marginStart="5dp"
                android:layout_marginTop="5dp"
                android:layout_marginEnd="5dp"
                android:layout_marginBottom="5dp"
                android:columnCount="2"
                android:columnOrderPreserved="false"
                android:rowCount="10">

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer1"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/redmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer1"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t1"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer2"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/redmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer2"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t2"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer3"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/redmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer3"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t3"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer4"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/greenmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer4"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t4"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer5"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/greenmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer5"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t5"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer6"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/greenmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer6"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t6"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer7"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/redmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer7"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t7"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer8"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/redmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer8"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t8"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer9"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/redmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer9"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t9"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer10"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/greenmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer10"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t10"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer11"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    android:layout_marginBottom="50dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/greenmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer11"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t11"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

                <androidx.cardview.widget.CardView
                    android:id="@+id/dryer12"
                    android:layout_width="150dp"
                    android:layout_height="180dp"
                    android:layout_margin="10dp"
                    android:layout_marginLeft="25dp"
                    android:layout_marginBottom="50dp"
                    app:cardCornerRadius="15dp"
                    app:cardElevation="8dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:orientation="vertical">

                        <ImageView
                            android:layout_width="100dp"
                            android:layout_height="100dp"
                            android:layout_centerInParent="true"
                            android:layout_marginTop="20dp"
                            android:padding="10dp"
                            android:src="@drawable/greenmachine" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_centerInParent="true"
                            android:text="@string/dryer12"
                            android:textSize="18sp"
                            android:textStyle="bold" />
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:gravity="center"
                            android:orientation="horizontal">
                            <ImageView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:src="@drawable/ic_timer"
                                android:scaleX="0.8"
                                android:scaleY="0.8"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="Left: "
                                android:textSize="18sp"
                                android:textStyle="bold"/>
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_centerInParent="true"
                                android:text="@string/dryer_t12"
                                android:textSize="18sp"
                                android:textStyle="bold"
                                android:layout_marginRight="5dp"/>
                        </LinearLayout>
                    </LinearLayout>

                </androidx.cardview.widget.CardView>

            </GridLayout>
        </LinearLayout>
    </ScrollView>
</RelativeLayout>
