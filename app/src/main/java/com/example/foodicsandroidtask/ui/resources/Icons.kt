package com.example.foodicsandroidtask.ui.resources

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Orders: ImageVector
    get() {
        if (_Orders != null) {
            return _Orders!!
        }
        _Orders = ImageVector.Builder(
            name = "Order",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(560f, 396f)
                verticalLineToRelative(-68f)
                quadToRelative(33f, -14f, 67.5f, -21f)
                reflectiveQuadToRelative(72.5f, -7f)
                quadToRelative(26f, 0f, 51f, 4f)
                reflectiveQuadToRelative(49f, 10f)
                verticalLineToRelative(64f)
                quadToRelative(-24f, -9f, -48.5f, -13.5f)
                reflectiveQuadTo(700f, 360f)
                quadToRelative(-38f, 0f, -73f, 9.5f)
                reflectiveQuadTo(560f, 396f)
                moveToRelative(0f, 220f)
                verticalLineToRelative(-68f)
                quadToRelative(33f, -14f, 67.5f, -21f)
                reflectiveQuadToRelative(72.5f, -7f)
                quadToRelative(26f, 0f, 51f, 4f)
                reflectiveQuadToRelative(49f, 10f)
                verticalLineToRelative(64f)
                quadToRelative(-24f, -9f, -48.5f, -13.5f)
                reflectiveQuadTo(700f, 580f)
                quadToRelative(-38f, 0f, -73f, 9f)
                reflectiveQuadToRelative(-67f, 27f)
                moveToRelative(0f, -110f)
                verticalLineToRelative(-68f)
                quadToRelative(33f, -14f, 67.5f, -21f)
                reflectiveQuadToRelative(72.5f, -7f)
                quadToRelative(26f, 0f, 51f, 4f)
                reflectiveQuadToRelative(49f, 10f)
                verticalLineToRelative(64f)
                quadToRelative(-24f, -9f, -48.5f, -13.5f)
                reflectiveQuadTo(700f, 470f)
                quadToRelative(-38f, 0f, -73f, 9.5f)
                reflectiveQuadTo(560f, 506f)
                moveTo(260f, 640f)
                quadToRelative(47f, 0f, 91.5f, 10.5f)
                reflectiveQuadTo(440f, 682f)
                verticalLineToRelative(-394f)
                quadToRelative(-41f, -24f, -87f, -36f)
                reflectiveQuadToRelative(-93f, -12f)
                quadToRelative(-36f, 0f, -71.5f, 7f)
                reflectiveQuadTo(120f, 268f)
                verticalLineToRelative(396f)
                quadToRelative(35f, -12f, 69.5f, -18f)
                reflectiveQuadToRelative(70.5f, -6f)
                moveToRelative(260f, 42f)
                quadToRelative(44f, -21f, 88.5f, -31.5f)
                reflectiveQuadTo(700f, 640f)
                quadToRelative(36f, 0f, 70.5f, 6f)
                reflectiveQuadToRelative(69.5f, 18f)
                verticalLineToRelative(-396f)
                quadToRelative(-33f, -14f, -68.5f, -21f)
                reflectiveQuadToRelative(-71.5f, -7f)
                quadToRelative(-47f, 0f, -93f, 12f)
                reflectiveQuadToRelative(-87f, 36f)
                close()
                moveToRelative(-40f, 118f)
                quadToRelative(-48f, -38f, -104f, -59f)
                reflectiveQuadToRelative(-116f, -21f)
                quadToRelative(-42f, 0f, -82.5f, 11f)
                reflectiveQuadTo(100f, 762f)
                quadToRelative(-21f, 11f, -40.5f, -1f)
                reflectiveQuadTo(40f, 726f)
                verticalLineToRelative(-482f)
                quadToRelative(0f, -11f, 5.5f, -21f)
                reflectiveQuadTo(62f, 208f)
                quadToRelative(46f, -24f, 96f, -36f)
                reflectiveQuadToRelative(102f, -12f)
                quadToRelative(58f, 0f, 113.5f, 15f)
                reflectiveQuadTo(480f, 220f)
                quadToRelative(51f, -30f, 106.5f, -45f)
                reflectiveQuadTo(700f, 160f)
                quadToRelative(52f, 0f, 102f, 12f)
                reflectiveQuadToRelative(96f, 36f)
                quadToRelative(11f, 5f, 16.5f, 15f)
                reflectiveQuadToRelative(5.5f, 21f)
                verticalLineToRelative(482f)
                quadToRelative(0f, 23f, -19.5f, 35f)
                reflectiveQuadToRelative(-40.5f, 1f)
                quadToRelative(-37f, -20f, -77.5f, -31f)
                reflectiveQuadTo(700f, 720f)
                quadToRelative(-60f, 0f, -116f, 21f)
                reflectiveQuadToRelative(-104f, 59f)
                moveTo(280f, 466f)
            }
        }.build()
        return _Orders!!
    }

private var _Orders: ImageVector? = null

public val Table: ImageVector
    get() {
        if (_Table != null) {
            return _Table!!
        }
        _Table = ImageVector.Builder(
            name = "Table",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(240f, 800f)
                lineToRelative(60f, -150f)
                quadToRelative(9f, -23f, 29f, -36.5f)
                reflectiveQuadToRelative(45f, -13.5f)
                horizontalLineToRelative(66f)
                verticalLineToRelative(-161f)
                quadToRelative(-153f, -5f, -256.5f, -45f)
                reflectiveQuadTo(80f, 300f)
                quadToRelative(0f, -58f, 117f, -99f)
                reflectiveQuadToRelative(283f, -41f)
                quadToRelative(167f, 0f, 283.5f, 41f)
                reflectiveQuadTo(880f, 300f)
                quadToRelative(0f, 54f, -103.5f, 94f)
                reflectiveQuadTo(520f, 439f)
                verticalLineToRelative(161f)
                horizontalLineToRelative(66f)
                quadToRelative(24f, 0f, 44.5f, 13.5f)
                reflectiveQuadTo(660f, 650f)
                lineToRelative(60f, 150f)
                horizontalLineToRelative(-80f)
                lineToRelative(-48f, -120f)
                horizontalLineTo(368f)
                lineToRelative(-48f, 120f)
                close()
                moveToRelative(240f, -440f)
                quadToRelative(97f, 0f, 183f, -17f)
                reflectiveQuadToRelative(126f, -43f)
                quadToRelative(-40f, -26f, -126f, -43f)
                reflectiveQuadToRelative(-183f, -17f)
                reflectiveQuadToRelative(-183f, 17f)
                reflectiveQuadToRelative(-126f, 43f)
                quadToRelative(40f, 26f, 126f, 43f)
                reflectiveQuadToRelative(183f, 17f)
                moveToRelative(0f, -60f)
            }
        }.build()
        return _Table!!
    }

private var _Table: ImageVector? = null

