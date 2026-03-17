package com.example.carenest

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class FamilyMemberItem(
    val name: String,
    val age: String,
    val relation: String
)

@Composable
fun FamilyMembersScreen() {
    val primaryGreen = Color(0xFF08A87D)
    val softGreen = Color(0xFFE8F7F2)
    val softBlue = Color(0xFFEAF3FF)
    val softPink = Color(0xFFFFF1F4)
    val textDark = Color(0xFF2E2B2B)
    val textLight = Color(0xFF6F6A6A)

    val familyMembers = listOf(
        FamilyMemberItem("Grandmother", "72", "Elder Care"),
        FamilyMemberItem("Father", "48", "Parent"),
        FamilyMemberItem("Mother", "45", "Parent"),
        FamilyMemberItem("Brother", "19", "Sibling")
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
                        text = "Family Members",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = textDark
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Manage members whose medicines need to be tracked",
                        fontSize = 14.sp,
                        color = textLight
                    )
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
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Add Family Member",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    FamilyStatCard(
                        modifier = Modifier.weight(1f),
                        title = "Members",
                        count = "4",
                        bgColor = softGreen,
                        countColor = primaryGreen
                    )
                    FamilyStatCard(
                        modifier = Modifier.weight(1f),
                        title = "Tracked",
                        count = "3",
                        bgColor = softBlue,
                        countColor = Color(0xFF3478F6)
                    )
                    FamilyStatCard(
                        modifier = Modifier.weight(1f),
                        title = "Active",
                        count = "2",
                        bgColor = softPink,
                        countColor = Color(0xFFE16A8B)
                    )
                }
            }

            items(familyMembers) { member ->
                FamilyMemberCard(
                    member = member,
                    primaryGreen = primaryGreen,
                    textDark = textDark,
                    textLight = textLight
                )
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun FamilyMemberCard(
    member: FamilyMemberItem,
    primaryGreen: Color,
    textDark: Color,
    textLight: Color
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
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFEAF7F2)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = primaryGreen
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = member.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = textDark
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    MemberInfoRow(
                        icon = Icons.Default.Schedule,
                        text = "Age: ${member.age}",
                        textColor = textLight
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    MemberInfoRow(
                        icon = Icons.Default.Favorite,
                        text = "Type: ${member.relation}",
                        textColor = textLight
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MemberActionChip(
                    modifier = Modifier.weight(1f),
                    text = "Edit",
                    icon = Icons.Default.Edit,
                    bgColor = Color(0xFFEAF3FF),
                    contentColor = Color(0xFF3478F6)
                )

                MemberActionChip(
                    modifier = Modifier.weight(1f),
                    text = "Delete",
                    icon = Icons.Default.DeleteOutline,
                    bgColor = Color(0xFFFFEFEF),
                    contentColor = Color(0xFFE35D5D)
                )
            }
        }
    }
}

@Composable
fun MemberInfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
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
fun MemberActionChip(
    modifier: Modifier = Modifier,
    text: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
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

@Composable
fun FamilyStatCard(
    modifier: Modifier = Modifier,
    title: String,
    count: String,
    bgColor: Color,
    countColor: Color
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bgColor)
            .padding(vertical = 18.dp, horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = count,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = countColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                color = Color(0xFF555555)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FamilyMembersScreenPreview() {
    MaterialTheme {
        Surface {
            FamilyMembersScreen()
        }
    }
}