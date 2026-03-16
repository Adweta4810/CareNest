package com.example.carenest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthScreen(
    startInSignUp: Boolean = false
) {
    var isSignUp by remember { mutableStateOf(startInSignUp) }

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val primary = Color(0xFF1EB49A)
    val secondary = Color(0xFFFF8A65)
    val textDark = Color(0xFF1D2B2A)
    val textLight = Color(0xFF6E7D7A)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFEAF7F3),
                        Color(0xFFDFF2EC),
                        Color(0xFFF4FBF8)
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .size(220.dp)
                .offset(x = (-40).dp, y = 40.dp)
                .blur(60.dp)
                .background(
                    color = Color(0x3328C7A7),
                    shape = RoundedCornerShape(200.dp)
                )
        )

        Box(
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.TopEnd)
                .offset(x = 30.dp, y = 80.dp)
                .blur(55.dp)
                .background(
                    color = Color(0x22FF9C7A),
                    shape = RoundedCornerShape(200.dp)
                )
        )

        Box(
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 10.dp)
                .blur(45.dp)
                .background(
                    color = Color(0x22AEEEDF),
                    shape = RoundedCornerShape(180.dp)
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(22.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlassCard {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 22.dp, vertical = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_carenest_logo),
                        contentDescription = "CareNest Logo",
                        modifier = Modifier.size(84.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row {
                        Text(
                            text = "Care",
                            color = primary,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Nest",
                            color = secondary,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Family medicine tracker",
                        color = textLight,
                        fontSize = 13.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color(0x14FFFFFF))
                            .padding(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(50.dp))
                                .background(if (!isSignUp) primary else Color.Transparent)
                                .clickable { isSignUp = false }
                                .padding(vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Sign In",
                                color = if (!isSignUp) Color.White else textDark,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(50.dp))
                                .background(if (isSignUp) primary else Color.Transparent)
                                .clickable { isSignUp = true }
                                .padding(vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Sign Up",
                                color = if (isSignUp) Color.White else textDark,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(22.dp))

                    if (isSignUp) {
                        AuthTextField(
                            value = fullName,
                            onValueChange = { fullName = it },
                            label = "Full Name"
                        )
                        Spacer(modifier = Modifier.height(14.dp))
                    }

                    AuthTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = "Email",
                        keyboardType = KeyboardType.Email
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    AuthTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = "Password",
                        isPassword = true,
                        passwordVisible = passwordVisible,
                        onTogglePassword = { passwordVisible = !passwordVisible }
                    )

                    if (isSignUp) {
                        Spacer(modifier = Modifier.height(14.dp))

                        AuthTextField(
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = "Confirm Password",
                            isPassword = true,
                            passwordVisible = confirmPasswordVisible,
                            onTogglePassword = { confirmPasswordVisible = !confirmPasswordVisible }
                        )
                    } else {
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = "Forgot Password?",
                                color = primary,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = primary)
                    ) {
                        Text(
                            text = if (isSignUp) "Create Account" else "Sign In",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            color = Color(0x22AAB8B4)
                        )
                        Text(
                            text = "  or continue with  ",
                            color = textLight,
                            fontSize = 12.sp
                        )
                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            color = Color(0x22AAB8B4)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        SocialLoginButton(
                            modifier = Modifier.weight(1f),
                            iconRes = R.drawable.ic_google,
                            text = "Google"
                        )

                        SocialLoginButton(
                            modifier = Modifier.weight(1f),
                            iconRes = R.drawable.ic_apple,
                            text = "Apple"
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        text = if (isSignUp) {
                            "Already have an account? Sign In"
                        } else {
                            "Don’t have an account? Sign Up"
                        },
                        color = textLight,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.clickable { isSignUp = !isSignUp }
                    )
                }
            }
        }
    }
}

@Composable
fun GlassCard(
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(30.dp),
                ambientColor = Color(0x2223B89B),
                spotColor = Color(0x2223B89B)
            )
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xD9FFFFFF))
            .border(
                width = 1.dp,
                color = Color(0x80FFFFFF),
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        Column(content = content)
    }
}

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onTogglePassword: (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (isPassword && !passwordVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xF7FFFFFF),
            unfocusedContainerColor = Color(0xF2FFFFFF),
            focusedBorderColor = Color(0xFF7FCFC1),
            unfocusedBorderColor = Color(0xFFCADDD7),
            focusedTextColor = Color(0xFF1D2B2A),
            unfocusedTextColor = Color(0xFF1D2B2A),
            focusedLabelColor = Color(0xFF5E716D),
            unfocusedLabelColor = Color(0xFF7B8A86),
            cursorColor = Color(0xFF1EB49A)
        ),
        trailingIcon = {
            if (isPassword && onTogglePassword != null) {
                IconButton(onClick = onTogglePassword) {
                    Icon(
                        imageVector = if (passwordVisible) {
                            Icons.Filled.Visibility
                        } else {
                            Icons.Filled.VisibilityOff
                        },
                        contentDescription = "Toggle Password",
                        tint = Color(0xFF7A8A86)
                    )
                }
            }
        }
    )
}

@Composable
fun SocialLoginButton(
    modifier: Modifier = Modifier,
    iconRes: Int,
    text: String
) {
    Row(
        modifier = modifier
            .height(54.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xF7FFFFFF))
            .border(
                width = 1.dp,
                color = Color(0xFFD9E8E3),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            color = Color(0xFF1D2B2A),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Sign In")
@Composable
fun SignInPreview() {
    MaterialTheme {
        Surface {
            AuthScreen(startInSignUp = false)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Sign Up")
@Composable
fun SignUpPreview() {
    MaterialTheme {
        Surface {
            AuthScreen(startInSignUp = true)
        }
    }
}