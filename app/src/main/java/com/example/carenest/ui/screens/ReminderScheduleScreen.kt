package com.example.carenest.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

data class ScheduledReminderItem(
    val medicineName: String,
    val time: String,
    val repeat: String,
    val notificationOn: Boolean
)

@Composable
fun ReminderScheduleScreen() {
    val primaryGreen = Color(0xFF08A87D)
    val softGreen = Color(0xFFE8F7F2)
    val softBlue = Color(0xFFEAF3FF)
    val softRed = Color(0xFFFFEFEF)
    val textDark = Color(0xFF2E2B2B)
    val textLight = Color(0xFF6F6A6A)

    var notificationsEnabled by remember { mutableStateOf(true) }
    var selectedRepeat by remember { mutableStateOf("Daily") }

    val reminders = listOf(
        ScheduledReminderItem(
            medicineName = "Paracetamol",
            time = "08:00 AM",
            repeat = "Daily",
            notificationOn = true
        ),
        ScheduledReminderItem(
            medicineName = "Vitamin D",
            time = "01:00 PM",
            repeat = "Mon, Wed, Fri",
            notificationOn = true
        ),
        ScheduledReminderItem(
            medicineName = "Blood Pressure Med",
            time = "08:30 PM",
            repeat = "Daily",
            notificationOn = false
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFEAE7EC),
                        Color(0xFFDDE3E8)
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.BottomStart)
                .offset(x = (-20).dp, y = (-10).dp)
                .blur(80.dp)
                .background(Color(0x6638E0CC), CircleShape)
        )

        Box(
            modifier = Modifier
                .size(140.dp)
                .align(Alignment.TopEnd)
                .offset(x = 30.dp, y = 30.dp)
                .blur(80.dp)
                .background(Color(0x33F2B6C8), CircleShape)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Column {
                    Text(
                        text = "Reminder Schedule",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = textDark
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Set reminder times and manage medicine schedules",
                        fontSize = 14.sp,
                        color = textLight
                    )
                }
            }

            item {
                GlassReminderCard {
                    Column {
                        Text(
                            text = "Reminder Time",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = textDark
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(18.dp))
                                .background(Color(0xFFF8FBFA))
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFE5EEEB),
                                    shape = RoundedCornerShape(18.dp)
                                )
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(softGreen),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AccessTime,
                                    contentDescription = null,
                                    tint = primaryGreen
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "08:00 AM",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = textDark
                                )
                                Text(
                                    text = "Tap to choose reminder time",
                                    fontSize = 12.sp,
                                    color = textLight
                                )
                            }

                            Text(
                                text = "Pick",
                                color = primaryGreen,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                modifier = Modifier.clickable { }
                            )
                        }
                    }
                }
            }

            item {
                GlassReminderCard {
                    Column {
                        Text(
                            text = "Repeat Options",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = textDark
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                RepeatChip(
                                    text = "Daily",
                                    isSelected = selectedRepeat == "Daily",
                                    selectedColor = primaryGreen,
                                    onClick = { selectedRepeat = "Daily" }
                                )
                                RepeatChip(
                                    text = "Mon",
                                    isSelected = selectedRepeat == "Mon",
                                    selectedColor = primaryGreen,
                                    onClick = { selectedRepeat = "Mon" }
                                )
                                RepeatChip(
                                    text = "Tue",
                                    isSelected = selectedRepeat == "Tue",
                                    selectedColor = primaryGreen,
                                    onClick = { selectedRepeat = "Tue" }
                                )
                                RepeatChip(
                                    text = "Wed",
                                    isSelected = selectedRepeat == "Wed",
                                    selectedColor = primaryGreen,
                                    onClick = { selectedRepeat = "Wed" }
                                )
                            }

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                RepeatChip(
                                    text = "Thu",
                                    isSelected = selectedRepeat == "Thu",
                                    selectedColor = primaryGreen,
                                    onClick = { selectedRepeat = "Thu" }
                                )
                                RepeatChip(
                                    text = "Fri",
                                    isSelected = selectedRepeat == "Fri",
                                    selectedColor = primaryGreen,
                                    onClick = { selectedRepeat = "Fri" }
                                )
                                RepeatChip(
                                    text = "Sat",
                                    isSelected = selectedRepeat == "Sat",
                                    selectedColor = primaryGreen,
                                    onClick = { selectedRepeat = "Sat" }
                                )
                                RepeatChip(
                                    text = "Sun",
                                    isSelected = selectedRepeat == "Sun",
                                    selectedColor = primaryGreen,
                                    onClick = { selectedRepeat = "Sun" }
                                )
                            }
                        }
                    }
                }
            }

            item {
                GlassReminderCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(softBlue),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null,
                                tint = Color(0xFF3478F6)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Notifications",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = textDark
                            )
                            Text(
                                text = "Turn reminder alerts on or off",
                                fontSize = 13.sp,
                                color = textLight
                            )
                        }

                        Switch(
                            checked = notificationsEnabled,
                            onCheckedChange = { notificationsEnabled = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = primaryGreen,
                                uncheckedThumbColor = Color.White,
                                uncheckedTrackColor = Color(0xFFD7DEDB)
                            )
                        )
                    }
                }
            }

            item {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryGreen)
                ) {
                    Icon(
                        imageVector = Icons.Default.AddAlarm,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Save Reminder",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            item {
                Text(
                    text = "Scheduled Reminders",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = textDark
                )
            }

            items(reminders) { reminder ->
                ScheduledReminderCard(
                    reminder = reminder,
                    primaryGreen = primaryGreen,
                    textDark = textDark,
                    textLight = textLight,
                    softGreen = softGreen,
                    softRed = softRed
                )
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun GlassReminderCard(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = Color(0x22000000),
                spotColor = Color(0x22000000)
            )
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xD9FFFFFF))
            .border(
                width = 1.dp,
                color = Color(0x80FFFFFF),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(16.dp)
    ) {
        content()
    }
}

@Composable
fun RepeatChip(
    text: String,
    isSelected: Boolean,
    selectedColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .background(if (isSelected) selectedColor else Color(0xFFF7FAF9))
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else Color(0xFFE2EBE8),
                shape = RoundedCornerShape(14.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color(0xFF53615E),
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ScheduledReminderCard(
    reminder: ScheduledReminderItem,
    primaryGreen: Color,
    textDark: Color,
    textLight: Color,
    softGreen: Color,
    softRed: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = Color(0x22000000),
                spotColor = Color(0x22000000)
            )
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xD9FFFFFF))
            .border(
                width = 1.dp,
                color = Color(0x80FFFFFF),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(softGreen),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = null,
                        tint = primaryGreen
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = reminder.medicineName,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = textDark
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    ReminderInfoRow(
                        icon = Icons.Default.AccessTime,
                        text = "Time: ${reminder.time}",
                        textColor = textLight
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    ReminderInfoRow(
                        icon = Icons.Default.Repeat,
                        text = "Repeat: ${reminder.repeat}",
                        textColor = textLight
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    ReminderInfoRow(
                        icon = Icons.Default.Notifications,
                        text = if (reminder.notificationOn) "Notification: On" else "Notification: Off",
                        textColor = if (reminder.notificationOn) primaryGreen else Color(0xFFE35D5D)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ReminderActionChip(
                    modifier = Modifier.weight(1f),
                    text = "Edit",
                    icon = Icons.Default.Edit,
                    bgColor = Color(0xFFEAF3FF),
                    contentColor = Color(0xFF3478F6)
                )

                ReminderActionChip(
                    modifier = Modifier.weight(1f),
                    text = "Delete",
                    icon = Icons.Default.DeleteOutline,
                    bgColor = softRed,
                    contentColor = Color(0xFFE35D5D)
                )
            }
        }
    }
}

@Composable
fun ReminderInfoRow(
    icon: ImageVector,
    text: String,
    textColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = textColor,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 13.sp,
            color = textColor
        )
    }
}

@Composable
fun ReminderActionChip(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    bgColor: Color,
    contentColor: Color
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(bgColor)
            .clickable { }
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = contentColor,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = text,
            color = contentColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReminderScheduleScreenPreview() {
    MaterialTheme {
        Surface {
            ReminderScheduleScreen()
        }
    }
}